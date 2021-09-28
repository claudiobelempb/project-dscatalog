import Image from 'next/image';
import { FaAlignJustify, FaSearch } from 'react-icons/fa';
import { InputContainer, InputDefaultSmall, InputIconDefault } from './styles';

const ImgSearch = './images/btn-search.svg';

type ImputDefaultProps = {
  placeholder: string;
  type?: 'search' | 'medium' | 'small' | 'full' | 'search';
  color?: boolean;
  onClick: () => void;
  onChange: () => void;
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
  onChange,
  placeholder,
}) => {
  const isColor = color ? color : 'color_black-500';
  const renderInput = () => {
    switch (type) {
      case 'search':
        return (
          <InputContainer onChange={onChange}>
            <InputDefaultSmall
              className={`${isColor} ${type}`}
              placeholder={placeholder}
            />
            {icon ? (
              <InputIconDefault onClick={onClick}>
                {/* <Image src={src} alt={alt} width={20} height={20} /> */}
                {/* <FaAlignJustify color={'red'} size={30} /> */}
                <FaSearch color={'red'} size={30} />
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
