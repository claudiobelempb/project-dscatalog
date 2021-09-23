import styled, { css } from 'styled-components';

type TextProps = {
  upcase: boolean;
  iscolor: string;
  mb: string | number;
};

export const TextP = styled.p`
  ${({ theme }) => css<TextProps>`
    display: flex;
    font-size: ${theme.fonts.sizes.ms};
    font-weight: normal;
    text-align: justify;
    line-height: 33px;
    letter-spacing: -0.015em;
    text-transform: ${(props) => (props.upcase ? 'uppercase' : 'none')};
    margin-bottom: ${(props) => (props.mb ? props.mb : 2)}rem;
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const TextSmall = styled.small`
  ${({ theme }) => css<TextProps>`
    display: flex;
    font-size: ${theme.fonts.sizes.mx};
    text-transform: ${(props) => (props.upcase ? 'uppercase' : 'none')};
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const TextSpan = styled.span`
  ${({ theme }) => css<TextProps>`
    display: flex;
    font-size: ${theme.fonts.sizes.mx};
    font-weight: bold;
    text-transform: ${(props) => (props.upcase ? 'uppercase' : 'none')};
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const TextStrong = styled.strong`
  ${({ theme }) => css<TextProps>`
    display: flex;
    font-size: ${theme.fonts.sizes.sx};
    text-transform: ${(props) => (props.upcase ? 'uppercase' : 'none')};
    color: ${(props) =>
      props.iscolor ? props.iscolor : theme.colors.black_100};
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;
