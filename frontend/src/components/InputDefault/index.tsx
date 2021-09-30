import Image from 'next/image';
import { FaAlignJustify, FaSearch } from 'react-icons/fa';
import { InputContainer, InputDefaultSmall, InputIconDefault } from './styles';

const ImgSearch = './images/btn-search.svg';

type ImputDefaultProps = {
  label?: string;
  placeholder: string;
  type?: 'text' | 'number' | 'search' | 'full' | 'search';
  color?: boolean;
  InputOnClick: () => void;
  InputOnChange: () => void;
  icon?: boolean;
  alt?: string;
};

export const InputDefault: React.FC<ImputDefaultProps> = ({
  label,
  color = false,
  type = 'Text alternative',
  icon = false,
  alt,
  InputOnClick,
  InputOnChange,
  placeholder,
}) => {
  const isColor = color ?? 'color_black-500';
  const renderInput = () => {
    switch (type) {
      case 'search':
        return (
          <InputContainer onChange={InputOnChange}>
            <label htmlFor="">{label ?? ''}</label>
            <InputDefaultSmall
              className={`${isColor} ${type}`}
              placeholder={placeholder ?? 'Digíte um placeholder'}
              type={type ?? 'text'}
              alt={alt ?? 'Text alternative'}
            />
            {icon ? (
              <InputIconDefault onClick={InputOnClick}>
                {/* <Image src={src} alt={alt} width={20} height={20} /> */}
                {/* <FaAlignJustify color={'red'} size={30} /> */}
                <FaSearch color={'red'} size={30} />
              </InputIconDefault>
            ) : (
              ''
            )}
          </InputContainer>
        );

      case 'number':
        return (
          <InputContainer onChange={InputOnChange}>
            <label htmlFor="">{label ?? ''}</label>
            <InputDefaultSmall
              className={`${isColor} ${type}`}
              placeholder={placeholder ?? 'Digíte um placeholder'}
              type={type ?? 'number'}
              alt={alt ?? 'Text alternative'}
            />
            {icon ? (
              <InputIconDefault onClick={InputOnClick}>
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
          <InputContainer onChange={InputOnChange}>
            <label htmlFor="">{label ?? ''}</label>
            <InputDefaultSmall
              className={`${isColor} ${type}`}
              placeholder={placeholder ?? 'Digíte um placeholder'}
              type={type}
              alt={alt}
            />
            {icon ? (
              <InputIconDefault onClick={InputOnClick}>
                {/* <Image src={src} alt={alt} width={20} height={20} /> */}
                {/* <FaAlignJustify color={'red'} size={30} /> */}
                <FaSearch color={'red'} size={30} />
              </InputIconDefault>
            ) : (
              ''
            )}
          </InputContainer>
        );
    }
  };

  return renderInput();
};
