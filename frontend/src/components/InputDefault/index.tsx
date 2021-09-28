import Image from 'next/image';
import { InputContainer, InputDefaultSmall, InputIconDefault } from './styles';

const ImgSearch = './images/btn-search.svg';

type ImputDefaultProps = {
  placeholder?: string;
  type?: 'search' | 'medium' | 'small' | 'full' | 'search';
  color?: boolean;
  onClick: () => void;
  icon?: boolean;
  alt?: string;
  src: string;
};

export const InputDefault: React.FC<ImputDefaultProps> = ({
  color = false,
  type = `search`,
  icon = false,
  alt,
  src,
  onClick,
}) => {
  const isColor = color ? color : 'color_black-500';
  const renderInput = () => {
    switch (type) {
      case 'search':
        return (
          <InputContainer>
            <InputDefaultSmall className={`${isColor} ${type}`} />
            {icon ? (
              <InputIconDefault onClick={onClick}>
                <Image src={src} alt={alt} width={25} height={25} />
              </InputIconDefault>
            ) : (
              ''
            )}
          </InputContainer>
        );

      default:
        return (
          <>
            <InputDefaultSmall className={`${isColor} ${type}`} />
            {icon ? (
              <InputIconDefault onClick={onClick}>
                <Image src={src} alt={alt} width={60} height={60} />
              </InputIconDefault>
            ) : (
              ''
            )}
          </>
        );
    }
  };

  return renderInput();
};
